[
  {
    'repeat(100)': {
      key: '{{index()}}',
      address: '1701 NCC Enterprise St.',
      values: {
        price: '{{integer(10000, 300000)}}',
        square_footage: '{{integer(100, 25000)}}',
        utilities: '{{random(0, 1)}}',
        number_bedrooms: '{{integer(0, 5)}}',
        number_bathrooms: '{{integer(0, 5)}}'
      }
    }
  }
]
