const tokenHeader = "Authorization";

$.ajaxSetup({
    headers: { "Authorization": $.cookie("token") },
    dataType: "json"
});

$(document).ajaxSend(function (event, xhr, settings) {
    settings.url = "/security" + settings.url;
});

$(document).ajaxComplete(function (event, xhr, settings) {
    
});