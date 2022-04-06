var rowTemplate = '<td class="zag">\
                           {{id}}\
                       </td>\
                       <td>\
                          <div id="firstnameUpdateButton{{id}}"> \
                               {{firstname}}\
                               <button type="button" name="UpdateFirstname"  onclick="showForm(\'firstnameForm{{id}}\',\'firstnameUpdateButton{{id}}\' )">\
                                   <img src="/static/image/edit.png" alt="Update" title="Update" width="15" height="15"/>\
                               </button>\
                           </div>\
                            <div id="firstnameForm{{id}}" style="display:none;">\
                                <form name="input" action="" method="post" >\
                                     <input name="firstname" type="text" value= "{{firstname}}"/>\
                                     <input  type="submit">\
                                </form>\
                            </div>\
                       </td>\
                       <td>\
                            <div id="cellLastname{{id}}">\
                                 {{lastname}}\
                               <button type="button" name="UpdateLastname" onclick="showForm(\'lastnameForm{{id}}\', \'cellLastname{{id}}\' )">\
                                   <img src="/static/image/edit.png" alt="Update" title="Update" width="15" height="15"/>\
                               </button>\
                           </div>\
                           <div id="lastnameForm{{id}}" style="display:none;">\
                               <form name="input" action="" method="post"  >\
                                    <input name="lastname" type="text" value="{{lastname}}"/>\
                                    <input  type="submit">\
                               </form>\
                            </div>\
                       </td>\
                       \
                       <td>\
                         <div id="cellPseudonym{{id}}">\
                              {{pseudonym}}\
                               <button type="button" name="UpdatePseudonym" onclick="showForm(\'pseudonymFrom{{id}}\', \'cellPseudonym{{id}}\' )">\
                                  <img src="/static/image/edit.png" alt="Update" title="Update" width="15" height="15"/>\
                               </button>\
                         </div>\
                          <div id="pseudonymFrom{{id}}" style="display:none;">\
                               <form name="input" action="" method="post" >\
                                   <input name="pseudonym" type="text" value="{{pseudonym}}"/>\
                                   <input  type="submit">\
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
                        .replaceAll("{{firstname}}", "firstname"+(i+1))
                        .replaceAll("{{lastname}}", "lastname"+(i+1))
                        .replaceAll("{{pseudonym}}", "pseudonym"+(i+1));

            tbodyElement.append(newRow);
        }

    function showForm(formName, cellName){
            var form = document.getElementById(formName);
            form.style.display = "block";

            var cell = document.getElementById(cellName);
            cell.style.display = "none";

    }

