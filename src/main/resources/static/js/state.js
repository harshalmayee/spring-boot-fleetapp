$('document').ready(function(){
  $('table #editButton').on('click',function(event){
    event.preventDefault();
    var href=$(this).attr('href');
    $.get(href,function(State,status){
      $('#idEdit').val(State.id);
      $('#ddlCountryEdit').val(State.countryId);
      $('#codeEdit').val(State.code);
      $('#nameEdit').val(State.name);
      $('#capitalEdit').val(State.capital);
      $('#detailsEdit').val(State.details);

    });
    $('#editModal').modal();
  });

  $('table #detailsButton').on('click',function(event){
      event.preventDefault();
      var href=$(this).attr('href');
      $.get(href,function(State,status){
        $('#idDetails').val(State.id);
        $('#ddlCountryDetails').val(State.countryId);
        $('#codeDetails').val(State.code);
        $('#nameDetails').val(State.name);
        $('#capitalDetails').val(State.capital);
        $('#detailsDetails').val(State.details);

      });
      $('#detailsModal').modal();
    });

  $('table #deleteButton').on('click',function(event){
    event.preventDefault();
    var href=$(this).attr('href');
    $('#confirmDeleteButton').attr('href',href);
    $('#deleteModal').modal();
  });
});

