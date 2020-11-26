$('document').ready(function(){
  $('table #editButton').on('click',function(event){
    event.preventDefault();
    var href=$(this).attr('href');
    $.get(href,function(contact,status){
      $('#txtEmailEdit').val(contact.email);
      $('#txtFirstNameEdit').val(contact.firstName);
      $('#txtIdEdit').val(contact.id);
      $('#txtLastNameEdit').val(contact.lastName);
      $('#txtMobileEdit').val(contact.mobile);
      $('#txtPhoneEdit').val(contact.phone);
      $('#txtRemarksEdit').val(contact.remarks);

    });
    $('#editModal').modal();
  });

  $('table #detailsButton').on('click',function(event){
      event.preventDefault();
      var href=$(this).attr('href');
      $.get(href,function(contact,status){
        $('#txtEmailDetails').val(contact.email);
        $('#txtFirstNameDetails').val(contact.firstName);
        $('#txtIdDetails').val(contact.id);
        $('#txtLastNameDetails').val(contact.lastName);
        $('#txtMobileDetails').val(contact.mobile);
        $('#txtPhoneDetails').val(contact.phone);
        $('#txtRemarksDetails').val(contact.remarks);
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

