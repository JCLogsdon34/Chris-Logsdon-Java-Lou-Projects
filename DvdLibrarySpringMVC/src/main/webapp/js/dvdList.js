$(document).ready(function () {

    // Add Button onclick handler
    $('#search-button').click(function (event) {

        $.ajax({
            type: 'POST',
            url: 'search/dvds',
            data: JSON.stringify({
                dvdTitle: $('#search-dvd-title').val(),
                releaseDate: $('#search-release-date').val(),
                directorsName: $('#directors-name').val(),
                rating: $('#search-rating').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json',
            success: function (data) {
                // clear errorMessages
                $('#errorMessages').empty();
                fillContactTable(data);
            },
            error: function () {
                $('#errorMessages')
                        .append($('<li>')
                                .attr({class: 'list-group-item list-group-item-danger'})
                                .text('Error calling web service.  Please try again later.'));
            }
        });
    });
});

function fillDvdTable(data) {
    // we need to clear the previous content so we don't append to it
    clearDvdTable();

    // grab the the tbody element that will hold the rows of contact information
    var contentRows = $('#contentRows');

    $.each(data, function (index, dvd) {
        var dvdTitle = dvd.dvdTitle;
        var releaseDate = dvd.releaseDate;
        var directorsName = dvd.directorsName;
        var rating = dvd.rating;

        var row = '<tr>';
        row += '<td>' + dvdTitle + '</td>';
        row += '<td>' + releaseDate + '</td>';
        row += '<td>' + directorsName + '</td>';
        row += '<td>' + rating + '</td>';
        row += '</tr>';
        contentRows.append(row);
    });
}

function clearDvdTable() {
    $('#contentRows').empty();
}