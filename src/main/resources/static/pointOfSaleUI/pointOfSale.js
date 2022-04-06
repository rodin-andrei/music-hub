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
                            <div id="cellLatitude{{id}}">\
                                 {{latitude}}\
                               <button type="button" name="UpdateLatitude" onclick="showForm(\'latitudeForm{{id}}\', \'cellLatitude{{id}}\' )">\
                                   <img src="/static/image/edit.png" alt="Update" title="Update" width="15" height="15"/>\
                               </button>\
                           </div>\
                           <div id="latitudeForm{{id}}" style="display:none;">\
                               <form name="input" action="" method="post"  >\
                                    <input name="latitude" type="text" value="{{latitude}}"/>\
                                    <input  type="submit">\
                               </form>\
                            </div>\
                       </td>\
                       \
                       <td>\
                         <div id="cellLongitude{{id}}">\
                             longitude {{id}}\
                               <button type="button" name="UpdateLongitude" onclick="showForm(\'longitudeFrom{{id}}\', \'cellLongitude{{id}}\' )">\
                                  <img src="/static/image/edit.png" alt="Update" title="Update" width="15" height="15"/>\
                               </button>\
                         </div>\
                          <div id="longitudeFrom{{id}}" style="display:none;">\
                               <form name="input" action="" method="post" >\
                                   <input name="longitude" type="text" value="{{longitude}}"/>\
                                   <input  type="submit">\
                               </form>\
                          </div>\
                       </td>\
                       \
                       <td>\
                      <div id="cellOffsetGMT{{id}}">\
                            offsetGMT {{id}}\
                                <button type="text" name="UpdateOffsetGMT" onclick="showForm(\'fromOffsetGMT{{id}}\', \'cellOffsetGMT{{id}}\' )">\
                                <img src="/static/image/edit.png" alt="Update" title="Update" width="15" height="15">\
                            </button>\
                      </div>\
                          <div id="fromOffsetGMT{{id}}" style="display:none;">\
                               <form name="input" action="" method="post">\
                                   <input name="title" type="text" value="{{offsetGMT}}">\
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
                    .replaceAll("{{latitude}}", "latitude"+(i+1))
                    .replaceAll("{{longitude}}", "longitude"+(i+1))
                    .replaceAll("{{offsetGMT}}", "offsetGMT"+(i+1))
                    .replaceAll("{{title}}", "title"+(i+1));

        tbodyElement.append(newRow);
    }

    function showForm(formName, cellName){
        var form = document.getElementById(formName);
        form.style.display = "block";

        var cell = document.getElementById(cellName);
        cell.style.display = "none";

    }

