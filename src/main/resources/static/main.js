$('document').ready(function () {

    // $('.table .btn-warning').on('click',function(event){
    //
    //     event.preventDefault();
    //
    //     var href= $(this).attr('href');
    //
    //     $.get(href, function(man, status){
    //         $('#modelEdit').val(man.modelFromPrinters);
    //
    //     });
    //
    //     $('#editModal').modal();
    //
    // });
    $('.table #deleteButton').on('click',function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
    });
})