/*$(document).ready(function() {
    $.ajax({
        url: "/books"
    }).then(function(data) {
    	console.log('data: ', data);
        $('.book1-name').append(data.eka.name);
        $('.book2-name').append(data.toka.name);
    });
});*/

var searchRequest = null;

$(function () {
    var minlength = 1;

    $("#search_book").keyup(function () {
        var that = this,
        value = $(this).val();

        if (value.length >= minlength ) {
            if (searchRequest != null) 
                searchRequest.abort();
            searchRequest = $.ajax({
                type: "GET",
                url: "/book",
                data: {
                    'name' : value
                },
                dataType: "text",
                success: function(data){
                    if (value==$(that).val()) {
                    	console.log(data);
                    	$('.book-name').append(data);
                    }
                }
            });
        }
    });
});