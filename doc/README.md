# YouTube Advertisement Recommender Web App
### 2024, Spring - Szabo Lorand

## Table of Contents
> 1. Introduction
> 2. Design 
> 3. Implementation
> 4. Testing
> 5. Demo
> 6. Future Improvements & Ideas
> 7. Bibliography

## 1. Introduction
### Objective
This is a university 'Software Design' project that focuses on the development of an app with an emphasis on backend functionality and a user-friendly interface.
### Idea
The goal of this app is to provide a platform for advertising companies in order to select appropiate YouTube channels for their ad. This recommendation is based on using the analysis of audience reach and views of videos related to specific topics matching the ad's theme.

## 2. Design
### 2.1. Use Cases

- __Actors__ and their __actions__: 
    - _Advertising Company_ - queries the potential success of their add and recommendations for successful collaborations.
    - _YouTube Observer_ - updates database upon changes in views, new videos, channels, or adds data on demand.

### 2.2. Class Diagram

![alt text](class_diagram-1.png)

### 2.3. Database Diagram

![alt text](db_diagram-1.png)

# 3. Implementation


## 4. Testing

### 4.*. Test Cases for Postman

- Reading all the Videos: GET localhost:8080/videos
- Reading all the Channels: GET localhost:8080/channels
- Reading all the Tags: GET localhost:8080/tags
- Inserting Tag: POST localhost:8080/tags


```js
{
    "name": "Funny",
    "relatedTags": 
    {
        "330c6c69-3c43-4cbb-97ed-aec61a9dede6": 0.95,
        "f2a7fd5c-be22-4afb-b700-4fd213e42440": 0.25
    } 
}
```