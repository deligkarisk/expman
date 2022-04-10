$(function () {
    $("#species").autocomplete({
        source: "/speciesAutocomplete",
        minLength: 2
    });
});
