package org.example;

import java.util.ArrayList;
import java.util.List;

/* Price combinations

We would like to implement an API for users to query availability for a single hotel.

The hotel availability
dataset
is in the following format:

{ date: [ { price, features, availability }, ... ], ... }


As a start, we would like to allow the user to make an availability query using the following
user input parameters:
	•	checkin (integer), checkin date
	•	checkout (integer), checkout date
	•	features (array of strings), features requested
	•	rooms (integer), the number of rooms requested
The
output
is a list of combinations of eligible rooms over the given checkin and checkout interval:
[
 {
 price, features, availability
},
… ]
 -------------------
Example dataset
{
  "176": [
    {
      "price": 120,
      "features": ["breakfast","refundable"],
      "availability": 5
    }
  ],
  "177": [
    {
      "price": 120,
      "features": ["breakfast","refundable"],
      "availability": 1
    },
    {
      "price": 130,
      "features": ["wifi","breakfast"],
      "availability": 3
    },
    {
      "price": 150,
      "features": ["wifi","breakfast","refundable"],
      "availability": 7
    }
  ]
}

output
[
  {
    "price": 240,
    "features": ["breakfast","refundable"],
    "availability": 1
  },
  {
    "price": 250,
    "features": ["breakfast"],
    "availability": 3
  },
  {
    "price": 270,
    "features": ["breakfast","refundable"],
    "availability": 5
  }
]

 user input parameters

{ checkin: 176, checkout: 178, features: [ 'breakfast' ], rooms: 1 }


 */
public record Price(int day, double price, List<String> features, int availability) {

}
