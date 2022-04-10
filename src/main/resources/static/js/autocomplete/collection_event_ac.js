$(function () {
    $("#collectionEvent").autocomplete({
        source: "/collectionEventCodesAutocomplete",
        minLength: 2
    });
});
