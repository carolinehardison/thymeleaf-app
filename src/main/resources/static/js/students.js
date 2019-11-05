$('document').ready(function(){

    $('.table #deleteButton').on('click',function(event){
        console.log("JQuery called");
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (student) {
            $('#idDelete').val(student.id);
            $('#studentDelete').text(student.name);
        });
        $('#deleteModal').modal();
    });


    $('.table #editButton').on('click',function(event){

        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (student, status) {
            $('#idEdit').val(student.id);
            $('#nameEdit').val(student.name);
            $('#departmentEdit').val(student.department);
            $('#updatedByEdit').val(student.updatedBy);

        });

        $('#editModal').modal();
    });
});