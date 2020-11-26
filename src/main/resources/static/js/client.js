$('document').ready(function(){
  $('table #editButton').on('click',function(event){
    event.preventDefault();
    var href=$(this).attr('href');
    $.get(href,function(client,status){
      $('#txtAddressEdit').val(client.address);
      $('#txtCityEdit').val(client.city);
      $('#ddlCountryEdit').val(client.countryId);
      $('#txtDetailsEdit').val(client.details);
      $('#txtEmailEdit').val(client.email);
      $('#txtIdEdit').val(client.id);
      $('#txtMobileEdit').val(client.mobile);
      $('#txtNameEdit').val(client.name);
      $('#txtPhoneEdit').val(client.phone);
      $('#ddlStateEdit').val(client.stateId);
      $('#txtWebsiteEdit').val(client.website);

    });
    $('#editModal').modal();
  });

  $('table #detailsButton').on('click',function(event){
      event.preventDefault();
      var href=$(this).attr('href');
      $.get(href,function(client,status){
        $('#txtAddressDetails').val(client.address);
        $('#txtCityDetails').val(client.city);
        $('#ddlCountryDetails').val(client.countryId);
        $('#txtDetailsDetails').val(client.details);
        $('#txtEmailDetails').val(client.email);
        $('#txtIdDetails').val(client.id);
        $('#txtMobileDetails').val(client.mobile);
        $('#txtNameDetails').val(client.name);
        $('#txtPhoneDetails').val(client.phone);
        $('#ddlStateDetails').val(client.stateId);
        $('#txtWebsiteDetails').val(client.website);

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

