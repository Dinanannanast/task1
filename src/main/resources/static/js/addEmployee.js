document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('countryInput').value = 'Казахстан';
    var citySelect = document.getElementById('cityInput');
    addOption(citySelect, 'Астана');
    addOption(citySelect, 'Алматы');
    addOption(citySelect, 'Шымкент');

    document.getElementById('iinError').style.display = 'inline';
    document.getElementById('iinInput').addEventListener('input', function (event) {
        if (!this.value) {
            document.getElementById('iinError').style.display = 'inline';
        } else {
            document.getElementById('iinError').style.display = 'none';
        }
    });

    document.getElementById('firstNameError').style.display = 'inline';
    document.getElementById('firstNameInput').addEventListener('input', function (event) {
        if (!this.value) {
            document.getElementById('firstNameError').style.display = 'inline';
        } else {
            document.getElementById('firstNameError').style.display = 'none';
        }
    });

    document.getElementById('secondNameError').style.display = 'inline';
    document.getElementById('secondNameInput').addEventListener('input', function (event) {
        if (!this.value) {
            document.getElementById('secondNameError').style.display = 'inline';
        } else {
            document.getElementById('secondNameError').style.display = 'none';
        }
    });

    document.getElementById('emailError').style.display = 'inline';
    document.getElementById('emailInput').addEventListener('input', function (event) {
        if (!this.value) {
            document.getElementById('emailError').style.display = 'inline';
        } else {
            document.getElementById('emailError').style.display = 'none';
        }
    });

    document.getElementById('phoneError').style.display = 'inline';
    document.getElementById('phoneInput').addEventListener('input', function (event) {
        if (!this.value) {
            document.getElementById('phoneError').style.display = 'inline';
        } else {
            document.getElementById('phoneError').style.display = 'none';
        }
    });

    document.getElementById('iinInput').oninvalid = function (event) {
        if (event.target.value === '' || event.target.value === null || event.target.value === undefined) {
            event.target.setCustomValidity('Поле не может быть пустым');
        } else if (event.target.value.length !== 12) {
            event.target.setCustomValidity('ИИН должен состоять из 12 цифр');
        } else {
            event.target.setCustomValidity('');
        }
    };
    document.getElementById('firstNameInput').oninvalid = function (event) {
        if (event.target.value === '' || event.target.value === null || event.target.value === undefined) {
            event.target.setCustomValidity('Поле не может быть пустым');
        } else {
            event.target.setCustomValidity('');
        }
    };
    document.getElementById('secondNameInput').oninvalid = function (event) {
        if (event.target.value === '' || event.target.value === null || event.target.value === undefined) {
            event.target.setCustomValidity('Поле не может быть пустым');
        } else {
            event.target.setCustomValidity('');
        }
    };
    document.getElementById('phoneInput').oninvalid = function (event) {
        if (event.target.value === '' || event.target.value === null || event.target.value === undefined) {
            event.target.setCustomValidity('Поле не может быть пустым');
        } else {
            event.target.setCustomValidity('');
        }
    };
    document.getElementById('emailInput').oninvalid = function (event) {
        if (event.target.value === '' || event.target.value === null || event.target.value === undefined) {
            event.target.setCustomValidity('Поле не может быть пустым');
        } else {
            event.target.setCustomValidity('');
        }
    };

    document.getElementById('countryInput').addEventListener('change', function () {
        var country = this.value;
        var citySelect = document.getElementById('cityInput');
        citySelect.innerHTML = '';
        if (country === 'Казахстан') {
            addOption(citySelect, 'Астана');
            addOption(citySelect, 'Алматы');
            addOption(citySelect, 'Шымкент');
        } else if (country === 'Россия') {
            addOption(citySelect, 'Москва');
            addOption(citySelect, 'Санкт-Петербург');
            addOption(citySelect, 'Екатеринбург');
        } else if (country === 'США') {
            addOption(citySelect, 'Нью-Йорк');
            addOption(citySelect, 'Лос-Анджелес');
            addOption(citySelect, 'Чикаго');
        }
    });

    function addOption(selectElement, optionText) {
        var option = document.createElement('option');
        option.text = optionText;
        selectElement.add(option);
    }

    document.getElementById('addEmployeeForm').addEventListener('submit', function(event) {
        event.preventDefault();

        var formData = new FormData(this);
        var jsonData = {};

        formData.forEach(function(value, key) {
            jsonData[key] = value;
        });

        fetch('/api/empl/save', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(jsonData)
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Ошибка при сохранении сотрудника');
                }
                return response.json();
            })
            .then(data => {
                window.location.href = '/employee.html';
            })
            .catch(error => {
                console.error('Ошибка:', error);
            });
    });
});
