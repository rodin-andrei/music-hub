package hub.music.feature.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CrudService<T, ID> {
    protected final JpaSpecificationExecutor<T> executor;
    protected final JpaRepository<T, ID> repository;

    private final List<OnDeleteListener<T>> onDeleteListeners;
    private final List<OnSaveListener<T>> onSaveListeners;

    public CrudService(JpaSpecificationExecutor<T> executor) {
        this.executor = executor;
        this.onDeleteListeners = new CopyOnWriteArrayList<>();
        this.onSaveListeners = new CopyOnWriteArrayList<>();

        this.repository = (JpaRepository<T, ID>) executor;
    }

    public void addOnDeleteListener(OnDeleteListener<T> onDeleteListener) {
        onDeleteListeners.add(onDeleteListener);
    }

    public void addOnSaveListener(OnSaveListener<T> onSaveListener) {
        onSaveListeners.add(onSaveListener);
    }

    public T getById(ID id) {
        if (id == null) {
            return null;
        }

        if (!repository.existsById(id)) {
            return null;
        }

        //noinspection OptionalGetWithoutIsPresent
        return  repository.findById(id).get();
    }

    public void flush() {
        repository.flush();
    }

    public T save(T obj) {
        notifyOnSaveListenersBeforeSave(obj);
        T save = repository.save(obj);
        notifyOnSaveListenersAfterSave(obj);

        return save;
    }

    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        if (entities == null) {
            throw new IllegalArgumentException("entities must not be null");
        }

        for (S entity : entities) {
            if (entity == null) {
                throw new IllegalArgumentException("entities must not contain null");
            }
        }

        return repository.saveAll(entities);
    }

    public List<T> queryAll() {
        return repository.findAll();
    }

    public List<T> queryAll(Specification<T> specification) {
        return executor.findAll(specification);
    }

    /**
     * @param pageIndex page number. First page - 1
     */
    public List<T> queryPage(int pageIndex, int pageSize, Specification<T> specification) {
        Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
        Page<T> page = executor.findAll(specification, pageable);
        return page.getContent();
    }

    public int getPageCount(int pageSize, Specification<T> specification) {
        int totalRecordCount = (int) count(specification);

        int result = totalRecordCount / pageSize;
        if (totalRecordCount % pageSize != 0) {
            result++;
        }

        return result;
    }

    public void deleteById(ID id) {
        boolean entityExists = exists(id);

        boolean shouldNotifyListeners = !onDeleteListeners.isEmpty() && entityExists;


        T entityToDelete = null;

        if (entityExists) {
            entityToDelete = getById(id);
        }

        if (shouldNotifyListeners) {
            notifyOnDeleteListenersBeforeDeleteSingle(entityToDelete);
        }

        if (entityExists) {
            repository.deleteById(id);
        }

        if (shouldNotifyListeners) {
            notifyOnDeleteListenersAfterDeleteSingle(entityToDelete);
        }
    }

    public void deleteAllInBatch(Iterable<T> entities) {
        if (entities == null) {
            throw new IllegalArgumentException("ids must not be null");
        }

        repository.deleteAllInBatch(entities);
    }

    public long count(Specification<T> specification) {
        return (int) executor.count(specification);
    }

    public long countAll() {
        return repository.count();
    }

    public void clear() {
        notifyOnDeleteListenersBeforeClear();

        repository.deleteAll();

        notifyOnDeleteListenersAfterClear();
    }

    public boolean exists(ID id) {
        if (id == null) {
            return false;
        }

        return repository.existsById(id);
    }

    private void notifyOnDeleteListenersBeforeDeleteSingle(T entity) {
        for (OnDeleteListener<T> onDeleteListener : onDeleteListeners) {
            onDeleteListener.beforeDelete(entity);
        }
    }

    private void notifyOnDeleteListenersAfterDeleteSingle(T entity) {
        for (OnDeleteListener<T> onDeleteListener : onDeleteListeners) {
            onDeleteListener.afterDelete(entity);
        }
    }

    private void notifyOnDeleteListenersBeforeClear() {
        for (OnDeleteListener<T> onDeleteListener : onDeleteListeners) {
            onDeleteListener.beforeClear();
        }
    }

    private void notifyOnDeleteListenersAfterClear() {
        for (OnDeleteListener<T> onDeleteListener : onDeleteListeners) {
            onDeleteListener.afterClear();
        }
    }

    private void notifyOnSaveListenersBeforeSave(T entity) {
        for (OnSaveListener<T> onSaveListener : onSaveListeners) {
            onSaveListener.beforeSave(entity);
        }
    }

    private void notifyOnSaveListenersAfterSave(T entity) {
        for (OnSaveListener<T> onSaveListener : onSaveListeners) {
            onSaveListener.afterSave(entity);
        }
    }

    public interface OnDeleteListener<T> {
        void beforeDelete(T entity);
        void afterDelete(T entity);
        @SuppressWarnings("EmptyMethod")
        void beforeClear();
        void afterClear();
    }

    public interface OnSaveListener<T> {
        void beforeSave(T entity);
        void afterSave(T entity);
    }
}