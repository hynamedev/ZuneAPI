MongoDB Test Dataset

To seed your database with the dump, run the following command:

```
mongorestore -h 127.0.0.1:27017 -d zune dump/zune/
```

To make a complete dump of your current `zune` instance, run the following command:

```
mongodump --host localhost --port 27017 -d zune
```

To delete the current instance of your `zune` database:

```
mongo zune --eval "db.dropDatabase()"
```

