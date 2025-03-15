package LLDUrlShorten;

public class UrlData {
    private String longUrl;
    private final String shortUrl;
    private int hitCount;
    private final long createdAt;
    private long lastAccessedAt;

    public UrlData(String longUrl, String shortUrl) {
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
        this.hitCount = 0;
        this.createdAt = System.currentTimeMillis();
        this.lastAccessedAt = createdAt;
    }

    public String getLongUrl() { return longUrl; }
    public void setLongUrl(String newUrl) { this.longUrl = newUrl; }

    public int getHitCount() { return hitCount; }
    public void incrementHitCount() {
        hitCount++;
        lastAccessedAt = System.currentTimeMillis();
    }

    public long getLastAccessedAt() { return lastAccessedAt; }
}

