function getResult() {
	var title = $('#title').val();
	var author = $('#author').val();
	var data = {
		title : title,
		author : author
	};
	var url = '/books';

	$.ajax({
		type : "GET",
		url : url,
		data : data,
		dataType : "text",
	}).then(
		function(data) {
			var data = JSON.parse(data);
			console.log('Books by author(' + author + ') and title ('
					+ title + ') ', data);
			$('#results').html('<div>');
			$('#count').html('<h3>Books found ' + data.length + ':</h3>');
			data.forEach(function(s, index) {
				var authors = '';
				s.volumeInfo.authors.forEach(function(auth, index) {
					authors += auth;
					if(index < s.volumeInfo.authors.length-1) {
						authors += ', ';
					}
				});
				var img = (s.volumeInfo.imageLinks != null) ? '<img src="' + s.volumeInfo.imageLinks.thumbnail + '" >' : ''; 
				var str = '<div id="resultItem">' + img + '<h2>' + (index+1) + '. ' + s.volumeInfo.title + '</h2>'
						+ '<p><b>by ' + authors + '</b></p>' + '<p>' + s.volumeInfo.description + ' <a href="' 
						+ s.volumeInfo.previewLink	+ '">More info...</a></p></div>';
				$('#results').append(str);
			});
			$('#results').append('</div>');
		});
}
