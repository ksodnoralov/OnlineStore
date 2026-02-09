package org.skypro.skyshop.article;

public class Article {
    private String articleName;
    private String articleText;

    public Article(String articleName, String articleText) {
        this.articleName = articleName;
        this.articleText = articleText;
    }

    public String getArticleName() {
        return articleName;
    }

    public String getArticleText() {
        return articleText;
    }

    @Override
    public String toString() {
        return articleName + articleText;
    }
}
