```
Movie {
	mno BIGINT(20) PRIMARY KEY,
	title VARCHAR(255),
	moddate DATETIME(6),
	regdate DATETIME(6)
}
```

```
MovieImage {
	inum BIGINT(20) PRIMARY KEY,
	uuid VARCHAR(255),
	imgName VARCHAR(255),
	path VARCHAR(255),
	movie BIGINT(20) FOREIGN KEY
}
```

```
Member {
	mid BIGINT(20) PRIMARY KEY,
	email VARCHAR(255),
	pw VARCHAR(255),
	nickname VARCHAR(255),
	moddate DATETIME(6),
	regdate DATETIME(6)
}
```

```
Review {
	reviewnum BIGINT(20) PRIMARY KEY,
	movie BIGINT(20) FOREIGN KEY,
	member BIGINT(20) FOREIGN KEY,
	grade INT,
	text VARCHAR(255),
	moddate DATETIME(6),
	regdate DATETIME(6)
}
```

