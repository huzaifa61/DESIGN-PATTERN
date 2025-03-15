package LLDUrlShorten;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// Interface for URL Shortener
public interface urlShortener {
    String shortenUrl(String longUrl, String customAlias);
    String shortenUrl(String longUrl);
    String getLongUrl(String shortUrl);
    boolean deleteUrl(String shortUrl);
    void updateUrl(String shortUrl, String newLongUrl);
    int getHitCount(String shortUrl);
}

// Implementation using in-memory HashMap
 class UrlShortenerImpl implements urlShortener {
    private final Map<String, UrlData> urlMapping; // Short URL -> UrlData
    private final Map<String, String> longToShort; // Long URL -> Short URL
    private final Random random;

    public UrlShortenerImpl() {
        urlMapping = new HashMap<>();
        longToShort = new HashMap<>();
        random = new Random();
    }

    @Override
    public String shortenUrl(String longUrl, String customAlias) {
        if (customAlias != null && urlMapping.containsKey(customAlias)) {
            throw new IllegalArgumentException("Alias already taken");
        }
        String shortUrl = (customAlias != null) ? customAlias : generateShortUrl();
        UrlData data = new UrlData(longUrl, shortUrl);
        urlMapping.put(shortUrl, data);
        longToShort.put(longUrl, shortUrl);
        return shortUrl;
    }

    @Override
    public String shortenUrl(String longUrl) {
        return shortenUrl(longUrl, null);
    }

    @Override
    public String getLongUrl(String shortUrl) {
        UrlData data = urlMapping.get(shortUrl);
        if (data == null) return null;
        data.incrementHitCount(); // Track URL usage
        return data.getLongUrl();
    }

    @Override
    public boolean deleteUrl(String shortUrl) {
        if (!urlMapping.containsKey(shortUrl)) return false;
        String longUrl = urlMapping.get(shortUrl).getLongUrl();
        urlMapping.remove(shortUrl);
        longToShort.remove(longUrl);
        return true;
    }

    @Override
    public void updateUrl(String shortUrl, String newLongUrl) {
        if (!urlMapping.containsKey(shortUrl)) throw new IllegalArgumentException("Short URL does not exist");
        urlMapping.get(shortUrl).setLongUrl(newLongUrl);
    }

    @Override
    public int getHitCount(String shortUrl) {
        return urlMapping.getOrDefault(shortUrl, new UrlData("", "")).getHitCount();
    }

    private String generateShortUrl() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder("my/");
        for (int i = 0; i < 6; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }
}

