[
  {
    'repeat(100)': {
      key: '{{index()}}',
      address: '{{lorem(1, "words")}}',
      values: {
        square_footage: '{{integer(1000, 25000)}}',
        price: function (tags) {
          return this.square_footage * 20;
        },
        utilities: '{{random(0, 1)}}',
        number_bedrooms: '{{integer(1, 5)}}',
        number_bathrooms: '{{integer(1, 5)}}'
      }
    }
  }
]
