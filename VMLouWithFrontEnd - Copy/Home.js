$(document).ready(function () {
    
	loadItems();


        var haveValidationErrors = checkAndDisplayValidationErrors($('#add-form').find('input'));

        if (haveValidationErrors) {
            return false;
        }

		

	$('#add-form').on('click', function(event){
		$.ajax({
			type: 'Post',
			url: 'http://localhost:8080/item',
			data: JSON.stringify({
			   addPenny: $('#add-penny').val(),
			   addNickel: $('#add-nickel').val(),
			   addDime: $('#add-dime').val(),
			   addQuarter: $('#add-quarter').val(),
			}),
			headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
			},
			'datatype': 'json',
			success: function(){
			$('#errorMessages').empty();
		},

		error: function(){
			alert('FAILURE!');
		}

		});
	});

	$('#add-selection').on('click', function(){
		$.ajax({
			type: 'Put',
			url: 'http://localhost:8080/item' + $('#update-inventory').val(),
			data: JSON.stringify({
			   addMessage: $('#addMessage').val(),
			   addItem: $('#addItem').val(),
			}),
			headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
			},
			'datatype': 'json',
			success: function(){
			alert('SUCCESS!');
		},
		error: function(){
			alert('FAILURE!');
		}
		});
	});


});

function loadItems() {
   
    clearOrderButtons();

    var itemRows = $('#rows');

    $.ajax ({
        type: 'GET',
        url: 'http://localhost:8080/items',
        success: function (data, status) {
            $.each(data, function (index, contact) {
                var itemNumber = item.itemNumber;
				var itemName = item.itemName;
				var itemCost = item.itemCost;
				var itemInventory = itemInventory;
                var company = contact.company;
                var id = contact.contactId;

	   $.each(itemArray, function(index, item){
		var itemInfo = '<p>';
		itemInfo += 'Item Number: '  + item.itemNumber +  '</br>';
		itemInfo += 'Item Name: ' + item.itemName + '</br>';
		itemInfo += 'Item Cost: '  + item.itemCost +  '</br>';
		itemInfo += 'Item Inventory: ' + item.itemInventory + '</br>';
		itemInfo += '</p>';
		itemInfo += '<hr>';

        itemDiv.append(itemInfo)
		});
		},
		error: function(){
			alert('FAILURE!');
		}
	});

function clearItemButtons() {
    $('#rows').empty();
}

function checkAndDisplayValidationErrors(input) {
    $('#errorMessages').empty();

    var errorMessages = [];

    input.each(function() {

        if(!this.validity.valid)
        {
            var errorField = $('label[for='+this.id+']').text();
            errorMessages.push(errorField + ' ' + this.validationMessage);
        }
    });

    if (errorMessages.length > 0){
        $.each(errorMessages,function(index,message){
            $('#errorMessages').append($('<p>').attr({class: 'form-group-item form-group-item-danger'}).text(message));
        });
        return true;
    } else {
        return false;
    }
}

