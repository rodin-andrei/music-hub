var rowTemplate = '<td class="zag">\
                           {{id}}\
                       </td>\
                       <td>\
                            <div id="cellFirstname{{id}}">\
                                 {{firstname}}\
                               <button type="button" name="UpdateFirstname" onclick="showForm(\'firstnameForm{{id}}\', \'cellFirstname{{id}}\' )">\
                                   <img src="/static/image/edit.png" alt="Update" title="Update" width="15" height="15"/>\
                               </button>\
                           </div>\
                           <div id="firstnameForm{{id}}" style="display:none;">\
                               <form name="input" action="" method="post"  >\
                                    <input name="firstname" type="text" value="{{firstname}}"/>\
                                    <input  type="submit">\
                               </form>\
                            </div>\
                       </td>\
                       \
                       <td>\
                         <div id="cellLastname{{id}}">\
                             Lastname {{id}}\
                               <button type="button" name="UpdateLastname" onclick="showForm(\'lastnameFrom{{id}}\', \'cellLastname{{id}}\' )">\
                                  <img src="/static/image/edit.png" alt="Update" title="Update" width="15" height="15"/>\
                               </button>\
                         </div>\
                          <div id="lastnameFrom{{id}}" style="display:none;">\
                               <form name="input" action="" method="post" >\
                                   <input name="lastname" type="text" value="{{lastname}}"/>\
                                   <input  type="submit">\
                               </form>\
                          </div>\
                       </td>\
                       \
                       <td>\
                      <div id="mobilePhone{{id}}">\
                            mobilePhone {{id}}\
                                <button type="text" name="UpdateMobilePhone" onclick="showForm(\'fromMobilePhone{{id}}\', \'cellMobilePhone{{id}}\' )">\
                                <img src="/static/image/edit.png" alt="Update" title="Update" width="15" height="15">\
                            </button>\
                      </div>\
                          <div id="fromMobilePhone{{id}}" style="display:none;">\
                               <form name="input" action="" method="post">\
                                   <input name="mobilePhone" type="text" value="{{mobilePhone}}">\
                                   <input type="submit" />\
                               </form>\
                           </div>\
                       </td>\
                       \
                       <td>\
                           <div id="emailUpdateButton{{id}}"> \
                              {{email}}\
                                   <button type="button" name="UpdateEmail"  onclick="showForm(\'emailForm{{id}}\',\'emailUpdateButton{{id}}\' )">\
                                   <img src="/static/image/edit.png" alt="Update" title="Update" width="15" height="15"/>\
                                   </button>\
                          </div>\
                          <div id="emailForm{{id}}" style="display:none;">\
                                   <form name="input" action="" method="post" >\
                                       <input name="email" type="text" value= "{{title}}"/>\
                                       <input  type="submit">\
                                   </form>\
                          </div>\
                       </td>\
                       \
                       <td>\
                           <div id="passwordUpdateButton{{id}}"> \
                               {{password}}\
                                    <button type="button" name="UpdatePassword"  onclick="showForm(\'passwordForm{{id}}\',\'passwordUpdateButton{{id}}\' )">\
                                    <img src="/static/image/edit.png" alt="Update" title="Update" width="15" height="15"/>\
                                    </button>\
                           </div>\
                           <div id="passwordForm{{id}}" style="display:none;">\
                                    <form name="input" action="" method="post" >\
                                        <input name="password" type="text" value= "{{password}}"/>\
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
                    .replaceAll("{{mobilePhone}}", "mobilePhone"+(i+1))
                    .replaceAll("{{email}}", "email"+(i+1))
                    .replaceAll("{{password}}", "password"+(i+1))
                    .replaceAll("{{title}}", "title"+(i+1));

        tbodyElement.append(newRow);
    }

    function showForm(formName, cellName){
        var form = document.getElementById(formName);
        form.style.display = "block";

        var cell = document.getElementById(cellName);
        cell.style.display = "none";

    }