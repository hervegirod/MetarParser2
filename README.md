# MetarParser2
A fork of the mivek/MetarParser project on github. See https://github.com/mivek/MetarParser

This java lib provides a Metar and TAF decoder.

Use the MetarFacade class and its method decode to decode a metar.
Use the MetarFacade class and its method retrieveFromAirport to get the metar of an airport. This method take the icao code as parameter.
The trends of the metar are not parsed.

## Table of content

1.  [Model](#model)
    1.  [Enumerations](#enumerations)
    2.  [Classes](#classes)
2.  [Examples](#examples)
    1.  [Parse a metar](#parse-a-metar)
    2.  [Retrieve a metar](#retrieve-the-metar-of-an-airport)
    3.  [Parse a taf](#parse-a-taf)
    4.  [Retrieve a taf](#retrieve-a-taf)
3.  [Internationalization](#internationalization)
4.  [History](#history)


### Enumerations

The application contains numerous enumerations to represent data.

-   CloudType: to represent the type of cloud.
-   CloudQuantity: to represent the amount of clouds.
-   Intensity: to represent the intensity of a meteorological phenomenon.
-   Descriptive: to represent the descriptive of a meteorological phenomenon.
-   Phenomenon: to represent a phenomenon.
-   WeatherChangeTime: to represent a trend.
-   TimeIndicator: to represent the time of the trend.

### Classes

#### Airport

The airport class is composed of

-   Name
-   City
-   Country
-   IATA code
-   ICAO code
-   latitude
-   longitude
-   altitude
-   timezone
    Note: Depending on the source for the airports, fields can be null

#### Cloud

In this application a cloud is composed of 

-   CloudQuantity
-   CloudType (optional)
-   height (optional)

#### Country

A country is represented by its name.

#### Runway information

The runway information is composed of 

-   The name of the runway
-   The minimal visibility on the runway
-   The maximal visibility on the runway (optional)
-   The trend of the visibility (optional)

#### Visibility

The visibility class is composed of

-   The main visibility
-   The minimal visibility (optional)
-   The direction of the minimal visibility (optional)

#### WeatherCondition

The weather condition is class to represent a meteorological phenomenon.
A weather condition is composed of 

-   an intensity (optional)
-   a descriptive (optional)
-   a list of phenomenon

#### Wind

The wind class is composed of 

-   the speed
-   the direction
-   the speed of the gust
-   the minimal wind variation in degrees
-   the maximal wind variation in degrees
-   the unit of the wind's speed

#### WindShear

This class is a subclass of Wind.
It is composed of

-   the height of the wind shear.

### Trends

![trends diagram](trend.jpg)
Numerous classes represents the trends. Trends are stored inside a list of the metar object `Metar.getTrends()`.
Trends are composed of 

-   a Type (BECMG or TEMPO)
-   a wind
-   a visibility and vertical visibility
-   a list of clouds
-   a list of weather conditions
-   a list of `AbstractMetarTrendTime` to represent the time with its type (AT, FM, TL)

## Airports loading

By default, airports are loaded from the temporary file [airport.dat](metarParser-spi/src/main/resources/data/airports.dat)
It is possible to provide your own source of airports via spi.
See [spi](metarParser-spi/README.md) module for details. 

## Examples

### Parse a metar

Instantiate the metarFacade and use its method parse.

```java
String code = "LFPG 131830Z 19005KT 170V250 9999 -SHRA FEW040TCU SCT086 16/08 Q1011";
MetarService service = MetarService.getInstance();
Metar metar = service.decode(code);
```

### Retrieve the metar of an airport

Instantiate the metarFacade.
Use the its method retrieveFromAirport with the ICAO code of the airport.

```java
String icao = "LFPG";
MetarService service = MetarService.getInstance();
Metar metar = service.retrieveFromAirport(icao);
```

### Parse a taf

Use the TAFFacade to decode the taf.

```java
String message = "TAF LFPG 150500Z 1506/1612 17005KT 6000 SCT012 \n" 
                  +"TEMPO 1506/1509 3000 BR BKN006 PROB40 \n"
                  +"TEMPO 1506/1508 0400 BCFG BKN002 PROB40 \n"
                  +"TEMPO 1512/1516 4000 -SHRA FEW030TCU BKN040 \n" 
                  +"BECMG 1520/1522 CAVOK \n"
                  +"TEMPO 1603/1608 3000 BR BKN006 PROB40 \n"
                  +"TEMPO 1604/1607 0400 BCFG BKN002 TX17/1512Z TN07/1605Z";
TAFService service = TAFService.getInstance();
TAF taf = service.decode(message);
```

Lines of the message have to be separated by a "\\n" character.

### Retrieve a taf

Use the TAFFacade and the method retrieveFromAirport with the ICAO code of the airport.

```java
String icao = "LFPG";
TAFService service = TAFService.getInstance();
TAF taf = service.retrieveFromAirport(icao);
```

### Internationalization

English and french locales are supported by the library. The library uses the user's locale.
The default locale is english.

#### Change the locale and contributing

To change the locale use the static method `setLocale(Locale)` of the class `Messages.java`

```(java)
Messages.setLocale(Locale.FRENCH); // Changes the locale to french.
```

#### History
Changes from the original project:
0.1 : 
-  Remove Polish messages
-  Fix some messages
-  Make the toString() method for elements in TAF or METAR closer to a real decoded TAF or METAR
-  Add the Sear level pressure value
-  Compute the relative humidity 
-  Avoid to include in the string messages values not present in the TAF or METAR
-  Allow to get a compact, normal, or full message

0.2 : 
- Fix the humidity computation

0.3 : 
- Change the visibility text message from >10km to CAVOK

