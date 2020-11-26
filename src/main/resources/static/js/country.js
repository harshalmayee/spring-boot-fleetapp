$('document').ready(function(){
  $('table #editButton').on('click',function(event){
    event.preventDefault();
    var href=$(this).attr('href');
    $.get(href,function(Country,status){
      $('#idEdit').val(Country.id);
      $('#codeEdit').val(Country.code);
      $('#capitalEdit').val(Country.capital);
      $('#descriptionEdit').val(Country.description);
      $('#nationalityEdit').val(Country.nationality);
      $('#continentEdit').val(Country.continent);
    });
    $('#editModal').modal();
  });

  $('table #deleteButton').on('click',function(event){
    event.preventDefault();
    var href=$(this).attr('href');
    $('#confirmDeleteButton').attr('href',href);
    $('#deleteModal').modal();
  });
});

