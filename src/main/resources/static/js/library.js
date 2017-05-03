$(document).ready(function() {
	$.ajax({
		url : "/books"
	}).then(function(data) {
		console.log('All books: ', data);
	});

	$.ajax({
		type: "GET",
        url: "/author",
        data: {
            'author' : 'Stephen King'
        },
        dataType: "text",
		author : 'Stephen King',
	}).then(function(data) {
		console.log('Books by author(Stephen King) ', data);
	});

	$.ajax({
		type: "GET",
        url: "/title",
        data: {
            'title' : 'Carrie'
        },
        dataType: "text",
	}).then(function(data) {
		console.log('Books by title(Carrie): ', data);
	});

	
});
