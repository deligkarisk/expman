$(function () {
    $("#country").autocomplete({
        source: "/countryAutocomplete",
        minLength: 2
    });
});