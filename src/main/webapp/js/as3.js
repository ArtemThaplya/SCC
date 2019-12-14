$('document').ready(function () {

    $('#add').on('click', function () {
    var result;
        var entry = $('#addEntryToCSV').val();
        $.ajax({
            url: 'http://localhost:8080/addEntryToCSV',
            datatype: 'json',
            contentType: "application/json",
            data: {
                entry: entry
            },
            success: function (data) {
                result = data;
                alert(data);
            }
        });
    });

    $('#delete').on('click', function deleteEntry(f) {
        var result;
        var entry = f;

        $.ajax({
            url: 'http://localhost:8080/deleteEntryFromBucket',
            datatype: 'json',
            contentType: "application/json",
            data: {
                entryDelete: entryDelete
            },
            success: function (data) {
                result = data;
                alert("Запись удалена!")
            }
        });
    });
});