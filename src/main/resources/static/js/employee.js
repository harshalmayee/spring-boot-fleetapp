$('document').ready(function(){
  $('table #editButton').on('click',function(event){
    event.preventDefault();
    var href=$(this).attr('href');
    $.get(href,function(employee,status){
      $('#txtAddressEdit').val(employee.address);
      $('#txtCityEdit').val(employee.city);
      $('#ddlNationalityEdit').val(employee.countryId);
      var dob = employee.dateOfBirth.substr(0,10);
      $('#txtDateOfBirthEdit').val(dob);
      $('#txtEmailEdit').val(employee.email);
      $('#txtFirstNameEdit').val(employee.firstName);
      $('#ddlGenderEdit').val(employee.gender);
      $('#txtIdEdit').val(employee.id);
      $('#txtInitialsEdit').val(employee.initials);
      $('#txtLastNameEdit').val(employee.lastName);
      $('#ddlMaritalStatusEdit').val(employee.maritalStatus);
      $('#txtMobileEdit').val(employee.mobile);
      $('#txtOtherNameEdit').val(employee.otherName);
      $('#txtPhoneEdit').val(employee.phone);
      $('#fupPhotoEdit').val(employee.photo);
      $('#txtSSNEdit').val(employee.socialSecurityNumber);
      $('#ddlStateEdit').val(employee.stateId);
      $('#ddlTitleEdit').val(employee.title);
      $('#ddlEmployeeTypeEdit').val(employee.employeeTypeId);
      var hireDate = employee.hireDate.substr(0,10);
      $('#txtHireDateEdit').val(hireDate);
      $('#ddlJobTitleEdit').val(employee.jobTitleId);
    });
    $('#editModal').modal();
  });

  $('table #detailsButton').on('click',function(event){
      event.preventDefault();
      var href=$(this).attr('href');
      $.get(href,function(employee,status){
        $('#txtAddressDetails').val(employee.address);
        $('#txtCityDetails').val(employee.city);
        $('#ddlNationalityDetails').val(employee.countryId);
        var dob = employee.dateOfBirth.substr(0,10);
        $('#txtDateOfBirthDetails').val(dob);
        $('#txtEmailDetails').val(employee.email);
        $('#txtFirstNameDetails').val(employee.firstName);
        $('#ddlGenderDetails').val(employee.gender);
        $('#txtIdDetails').val(employee.id);
        $('#txtInitialsDetails').val(employee.initials);
        $('#txtLastNameDetails').val(employee.lastName);
        $('#ddlMaritalStatusDetails').val(employee.maritalStatus);
        $('#txtMobileDetails').val(employee.mobile);
        $('#txtOtherNameDetails').val(employee.otherName);
        $('#txtPhoneDetails').val(employee.phone);
        $('#fupPhotoDetails').val(employee.photo);
        $('#txtSSNDetails').val(employee.socialSecurityNumber);
        $('#ddlStateDetails').val(employee.stateId);
        $('#ddlTitleDetails').val(employee.title);
        $('#ddlEmployeeTypeDetails').val(employee.employeeTypeId);
        var hireDate = employee.hireDate.substr(0,10);
        $('#txtHireDateDetails').val(hireDate);
        $('#ddlJobTitleDetails').val(employee.jobTitleId);
      });
      $('#detailsModal').modal();
    });

  $('table #deleteButton').on('click',function(event){
    event.preventDefault();
    var href=$(this).attr('href');
    $('#delRef').attr('href',href);
    $('#deleteModal').modal();
  });

  $('.table #photoButton').on('click',function(event) {
  		event.preventDefault();
  		var href = $(this).attr('href');
  		$('#photoModal #employeePhoto').attr('src', href);
  		$('#photoModal').modal();
  	});
});

