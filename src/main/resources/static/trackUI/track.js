var rowTemplate = '<td class="zag">\
                           {{id}}\
                       </td>\
                       <td>\
                          <div id="titleUpdateButton{{id}}"> \
                               {{title}}\
                               <button type="button" name="UpdateTitle"  onclick="showForm(\'titleForm{{id}}\',\'titleUpdateButton{{id}}\' )">\
                                   <img src="/static/image/edit.png" alt="Update" title="Update" width="15" height="15"/>\
                               </button>\
                           </div>\
                            <div id="titleForm{{id}}" style="display:none;">\
                                <form name="input" action="" method="post" >\
                                     <input name="title" type="text" value= "{{title}}"/>\
                                     <input  type="submit">\
                                </form>\
                            </div>\
                       </td>\
                       <td>\
                            <div id="cellAuthor{{id}}">\
                                 {{author}}\
                               <button type="button" name="UpdateLatitude" onclick="showForm(\'authorForm{{id}}\', \'cellAuthor{{id}}\' )">\
                                   <img src="/static/image/edit.png" alt="Update" title="Update" width="15" height="15"/>\
                               </button>\
                           </div>\
                           <div id="authorForm{{id}}" style="display:none;">\
                               <form name="input" action="" method="post"  >\
                                    <input name="author" type="text" value="{{author}}"/>\
                                    <input  type="submit">\
                               </form>\
                            </div>\
                       </td>\
                       \
                       <td>\
                         <div id="cellTime{{id}}">\
                              {{time}}\
                               <button type="button" name="UpdateTime" onclick="showForm(\'timeFrom{{id}}\', \'cellTime{{id}}\' )">\
                                  <img src="/static/image/edit.png" alt="Update" title="Update" width="15" height="15"/>\
                               </button>\
                         </div>\
                          <div id="timeFrom{{id}}" style="display:none;">\
                               <form name="input" action="" method="post" >\
                                   <input name="time" type="text" value="{{time}}"/>\
                                   <input  type="submit">\
                               </form>\
                          </div>\
                       </td>\
                       \
                       <td>\
                      <div id="cellGenre{{id}}">\
                             {{genre}}\
                                <button type="text" name="UpdateGenre" onclick="showForm(\'fromGenre{{id}}\', \'cellGenre{{id}}\' )">\
                                <img src="/static/image/edit.png" alt="Update" title="Update" width="15" height="15">\
                            </button>\
                      </div>\
                          <div id="fromGenre{{id}}" style="display:none;">\
                               <form name="input" action="" method="post">\
                                   <input name="genre" type="text" value="{{genre}}">\
                                   <input type="submit" />\
                               </form>\
                           </div>\
                       </td>\
                       \
                       <td>\
                           <form name="input" action="" method="delete">\
                               <input type="submit" value="DELETE"/>\
                           </form>\
                       </td>';


    var table = document.getElementById("tableData");

    var tbodyElement;
    for (var i = 0; i < table.childNodes.length; i++) {
        if (table.childNodes[i].tagName == "TBODY") {
           tbodyElement = table.childNodes[i];
           break;
        }
    }

    for(var i = 0; i< 5 ; i++){
            var newRow =  document.createElement("tr");
            newRow.innerHTML = rowTemplate
                        .replaceAll("{{id}}", i+1)
                        .replaceAll("{{title}}", "title"+(i+1))
                        .replaceAll("{{author}}", "author"+(i+1))
                        .replaceAll("{{time}}", "time"+(i+1))
                        .replaceAll("{{genre}}", "genre"+(i+1));

            tbodyElement.append(newRow);
        }

    function showForm(formName, cellName){
           var form = document.getElementById(formName);
           form.style.display = "block";

           var cell = document.getElementById(cellName);
           cell.style.display = "none";

    }