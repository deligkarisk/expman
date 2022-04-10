$(function () {
    $("#biogeographicRegion").autocomplete({
        source: "/biogeographicRegionAutocomplete",
        minLength: 2
    });
});
