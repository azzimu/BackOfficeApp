$(document).ready(function () {
    //Cmpteur i pour ne pas rajouter indéfinement la liste 
    let i=0;
    $('a[href=catalogue]').on('click', function (event) {
        event.preventDefault();
        console.log("clique");

        if ($('body').children().length<6) {
            $.ajax({
                url: "rest/work",
                success: function (result) {
                    var catalog='';
                    console.log("success");
                    result.forEach(function(nextWork){
                        
                        if (i===0){
                        catalog=catalog.concat("<p class='work'>"+nextWork.title+" ("+nextWork.release+")<p/>");
                        
                    }
                    
                    });
                    
                    if (i===0)
                    $("a[href=catalogue]").after('<br>'+catalog);
                
                    i++;
                }
            });
        }
    });
});