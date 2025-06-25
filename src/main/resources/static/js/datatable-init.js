$(document).ready(function () {
  $("#prodottiTable").DataTable({
    pageLength: 10,
    lengthChange: false,
    language: {
      url: "//cdn.datatables.net/plug-ins/1.13.7/i18n/it-IT.json",
    },
  });
});
