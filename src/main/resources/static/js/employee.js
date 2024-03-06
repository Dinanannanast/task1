$(document).ready(function () {
    function fetchEmployees() {
        $.get("/api/empl/all", function (data) {
            $('#employeesBody').empty();

            $.each(data, function (index, employee) {
                if (employee.patronymic === null) {
                    employee.patronymic = '';
                }
                if (employee.country === null) {
                    employee.country = '';
                }
                if (employee.city === null) {
                    employee.city = '';
                }
                var row = '<tr>' +
                    '<td>' + employee.iin + '</td>' +
                    '<td>' + employee.firstName + '</td>' +
                    '<td>' + employee.secondName + '</td>' +
                    '<td>' + employee.patronymic + '</td>' +
                    '<td>' + employee.phone + '</td>' +
                    '<td>' + employee.email + '</td>' +
                    '<td>' + employee.country + '</td>' +
                    '<td>' + employee.city + '</td>' +
                    '</tr>';
                $('#employeesBody').append(row);
            });
        });
    }

    fetchEmployees();

    $('#searchForm').submit(function (event) {
        event.preventDefault();

        var searchValue = $('#searchInput').val();

        $.get("/api/empl/byFirstName", {name: searchValue}, function (data) {
            $('#employeesBody').empty();

            $.each(data, function (index, employee) {
                if (employee.patronymic === null) {
                    employee.patronymic = '';
                }
                if (employee.country === null) {
                    employee.country = '';
                }
                if (employee.city === null) {
                    employee.city = '';
                }
                var row = '<tr>' +
                    '<td>' + employee.iin + '</td>' +
                    '<td>' + employee.firstName + '</td>' +
                    '<td>' + employee.secondName + '</td>' +
                    '<td>' + employee.patronymic + '</td>' +
                    '<td>' + employee.phone + '</td>' +
                    '<td>' + employee.email + '</td>' +
                    '<td>' + employee.country + '</td>' +
                    '<td>' + employee.city + '</td>' +
                    '</tr>';
                $('#employeesBody').append(row);
            });
        });
    });
});
