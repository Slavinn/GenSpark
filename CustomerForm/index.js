const submitForm = () => {
  let firstName = document.forms.customerForm.firstName.value;
  let lastName = document.forms.customerForm.lastName.value;
  let addressOne = document.forms.customerForm.addressOne.value;
  let addressTwo = document.forms.customerForm.addressTwo.value;
  let city = document.forms.customerForm.city.value;
  let state = document.forms.customerForm.state.value;
  let zipCode = document.forms.customerForm.zipCode.value;
  let phoneNumber = document.forms.customerForm.phoneNumber.value;

  if (!validPhoneNumber(phoneNumber)) {
    console.log("invalid");
    alert("phone number is invalid");
    return false;
  }

  localStorage.setItem("first_name", firstName);
  localStorage.setItem("last_name", lastName);
  localStorage.setItem("address_one", addressOne);
  localStorage.setItem("address_two", addressTwo);
  localStorage.setItem("city", city);
  localStorage.setItem("state", state);
  localStorage.setItem("zip_code", zipCode);
  localStorage.setItem("phone_number", phoneNumber);
};

const validPhoneNumber = (phoneNumber) =>
  /^[+]*[(]{0,1}[0-9]{1,3}[)]{0,1}[-s./0-9]*$/g.test(phoneNumber);
