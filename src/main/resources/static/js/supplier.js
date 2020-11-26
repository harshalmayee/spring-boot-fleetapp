$('document').ready(function(){
  $('table #editButton').on('click',function(event){
    event.preventDefault();
    var href=$(this).attr('href');
    $.get(href,function(supplier,status){
      $('#txtAddressEdit').val(supplier.address);
      $('#txtCityEdit').val(supplier.city);
      $('#ddlCountryEdit').val(supplier.countryId);
      $('#txtDetailsEdit').val(supplier.details);
      $('#txtEmailEdit').val(supplier.email);
      $('#txtIdEdit').val(supplier.id);
      $('#txtMobileEdit').val(supplier.mobile);
      $('#txtNameEdit').val(supplier.name);
      $('#txtPhoneEdit').val(supplier.phone);
      $('#ddlStateEdit').val(supplier.stateId);
      $('#txtWebsiteEdit').val(supplier.website);
    });
    $('#editModal').modal();
  });

  $('table #detailsButton').on('click',function(event){
      event.preventDefault();
      var href=$(this).attr('href');
      $.get(href,function(supplier,status){
        $('#txtAddressDetails').val(supplier.address);
        $('#txtCityDetails').val(supplier.city);
        $('#ddlCountryDetails').val(supplier.countryId);
        $('#txtDetailsDetails').val(supplier.details);
        $('#txtEmailDetails').val(supplier.email);
        $('#txtIdDetails').val(supplier.id);
        $('#txtMobileDetails').val(supplier.mobile);
        $('#txtNameDetails').val(supplier.name);
        $('#txtPhoneDetails').val(supplier.phone);
        $('#ddlStateDetails').val(supplier.stateId);
        $('#txtWebsiteDetails').val(supplier.website);
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

