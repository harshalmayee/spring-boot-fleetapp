$('document').ready(function(){
  $('table #editButton').on('click',function(event){
    event.preventDefault();
    var href=$(this).attr('href');
    $.get(href,function(location,status){
      $('#idEdit').val(location.id);
      $('#cityEdit').val(location.city);
      $('#addressEdit').val(location.address);
      $('#ddlCountryEdit').val(location.countryId);
      $('#ddlStateEdit').val(location.stateId);
      $('#descriptionEdit').val(location.description);
      $('#detailsEdit').val(location.details);
    });
    $('#editModal').modal();
  });

  $('table #detailsButton').on('click',function(event){
      event.preventDefault();
      var href=$(this).attr('href');
      $.get(href,function(location,status){
        $('#idDetails').val(location.id);
        $('#cityDetails').val(location.city);
        $('#addressDetails').val(location.address);
        $('#ddlCountryDetails').val(location.countryId);
        $('#ddlStateDetails').val(location.stateId);
        $('#descriptionDetails').val(location.description);
        $('#detailsDetails').val(location.details);
      });
      $('#detailsModal').modal();
    });

  $('table #deleteButton').on('click',function(event){
    event.preventDefault();
    var href=$(this).attr('href');
    $('#delRef').attr('href',href);
    $('#deleteModal').modal();
  });
});

