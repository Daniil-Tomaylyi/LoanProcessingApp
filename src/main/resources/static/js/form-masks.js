document.addEventListener("DOMContentLoaded", function () {
    function formatPhone(input) {
        let value = input.value.replace(/\D/g, "");

        value = value.startsWith("8") ? "7" + value.slice(1) : value.startsWith("7") ? value : "7" + value;

        if (value.length > 11) value = value.slice(0, 11);

        let formatted = "+7";
        if (value.length > 1) formatted += " (" + value.slice(1, 4);
        if (value.length > 4) formatted += ") " + value.slice(4, 7);
        if (value.length > 7) formatted += "-" + value.slice(7, 9);
        if (value.length > 9) formatted += "-" + value.slice(9);

        input.value = formatted;
    }

    function formatPassport(input) {
        let value = input.value.replace(/\D/g, "").slice(0, 10);

        if (value.length > 8) {
            value = value.slice(0, 2) + "-" + value.slice(2, 4) + "-" + value.slice(4);
        } else if (value.length > 4) {
            value = value.slice(0, 2) + "-" + value.slice(2, 4) + "-" + value.slice(4);
        } else if (value.length > 2) {
            value = value.slice(0, 2) + "-" + value.slice(2);
        }

        input.value = value;
    }

    document.getElementById("phone").addEventListener("input", function () {
        formatPhone(this);
    });

    document.getElementById("passportNumber").addEventListener("input", function () {
        formatPassport(this);
    });
});
