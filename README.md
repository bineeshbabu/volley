# Easy Volley Implemntation

Simple implementaion of Volley library.
## Getting Started
Android volleylibrary is done in a simpler way. Dont need to worry about volleyresponses. Pass your parammeters and get the result.


### Installing

A step by step series of examples for beginners

1. Download this zip file

2. Extract folder 'easyvolley'.

3. Place it in the root folder.

4. In build.gradle add 
```
implementation project(':easyvolley')

```
 
5. In settings.gradle add
```
include ':easyvolley'

```
6. Sync your gradle.

## In Youractivity.java file
```
JsonParserVolley request = new JsonParserVolley(this);
```

### Add url

```
request.addurl("http://www.test.com/api/hello");
```
### Add method

```
request.addmethod(Request.Method.POST);  
```

### Add header

```
request.addHeader(key, value);
...  
```
### Add body

```
request.addBody(key,value);
request.addBody(key,value);
...
...
```
### Response 
```
request.executeRequest( new VolleyCallback() {
                                             @Override
                                             public void getResponse(String response) {
                                                 String jObject = response;
                                                 Toast.makeText(getApplicationContext(), jObject, Toast.LENGTH_SHORT).show();
                                             }

                                             @Override
                                             public void failedresponse(String message) {
                                                 Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                                             }
                                         }
        );
```

## Built With

* [Volley](https://github.com/google/volley/) - Volleylibrary


