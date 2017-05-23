# java-data-image
Package provides java implementation of some common api of image manipulation in the form of data frame

[![Build Status](https://travis-ci.org/chen0040/java-data-image.svg?branch=master)](https://travis-ci.org/chen0040/java-data-image) [![Coverage Status](https://coveralls.io/repos/github/chen0040/java-data-image/badge.svg?branch=master)](https://coveralls.io/github/chen0040/java-data-image?branch=master)


# Install

Add the following dependency to your POM file:

```xml
<dependency>
  <groupId>com.github.chen0040</groupId>
  <artifactId>java-data-image</artifactId>
  <version>1.0.1</version>
</dependency>
```

# Usage

The sample code below shows how to convert an image to a data frame (Please refers to this [link](https://github.com/chen0040/java-data-frame) on how to use a data frame):

```java
BufferedImage img= ImageIO.read(new FileInputStream("1.jpg"));

DataFrame batch = ImageDataFrameFactory.dataFrame(img);

System.out.println(batch.head(10));
```
