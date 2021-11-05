$('document').ready(function () {

    $('.table #deleteButton').on('click',function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
    });

})

$('document').ready(function () {


    const form = document.getElementById('addManufacturers');
    const modelFromPrinters = document.getElementById('modelFromPrinters');
    form.addEventListener('submit', e => {
        const modelFromPrintersValue = modelFromPrinters.value.trim();
        let table1 = document.getElementById('models');
        let firstChilds = table1.querySelectorAll("td:first-child");
        let allName = [];
        for(let i=0; i<firstChilds.length; ++i){
            allName.push(firstChilds[i].innerHTML);
        }
        let modelka = null;
        for (let i=0;i<allName.length;i++) {
            modelka = allName[i];
            if (modelFromPrintersValue.toString() === modelka.toString() || modelFromPrintersValue === '') {
                setErrorFor(modelFromPrinters, 'Поле не может быть пустым или такой производитель уже есть');
                e.preventDefault();
            }
        }
    });
    function setErrorFor(input, message) {
        const formControl = input.parentElement;
        const small = formControl.querySelector('small');
        formControl.className = 'form-control error';
        small.innerText = message;
    }
})