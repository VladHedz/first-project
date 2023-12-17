package lesson7;

public class JsonExample {

    RequestExample1:
    {
        "size": 50,
        "radius": 3,
        "percentage_of_buckets": 10
    }

    ResponseExample1:
    {
        "meta": {
        "response": {
            "buckets": {
                "total": 12,
                "successful": 12,
                "skipped": 0,
                "failed": 0
            },
            "total": 47,
            "took": 0.009040875
        }
    },
        "result": [
        {
            "user_id": 100000000,
            "user_hid": "xA62peWqP4Ev1",
            "distance": 0
        },
        {
            "user_id": 200000000,
            "user_hid": "xA62peWqP4Ev2",
            "distance": 2
        },
        {
            "user_id": 300000000,
            "user_hid": "xA62peWqP4Ev3",
            "distance": 2
        },
        {
            "user_id": 400000000,
            "user_hid": "xA62peWqP4Ev4",
            "distance": 3
        }
    ],
        "errors": null
    }


    RequestExample2:
    {
        "page": 1
        "per_page": 20
        "product_id": 58
        "country_id": 161
        "city_id": 617932
        "age_to": 33
        "age_from": 29
        "weight_to": 180
        "weight_from": 40
        "height_to": 220
        "height_from": 120
        "search_gender": 1
        "gender": 2
        "new": false
        "email_confirmed": false
        "online": false
    }

    ResponseExample2:
    {
        {
            "meta": {
            "response": {
                "current_page": 1,
                "page_count": 1,
                "per_page": 20,
                "total_count": 2
            }
        },
            "result": [
            {
                "user_id": 100000000,
                "user_hid": "xA62peWqP4Ev1",
                "consumer_id": 100000001
            },
            {
                "user_id": 200000000,
                "user_hid": "xA62peWqP4Ev2",
                "consumer_id": 200000002
            }
    ],
            "errors": null
        }
    }

}
