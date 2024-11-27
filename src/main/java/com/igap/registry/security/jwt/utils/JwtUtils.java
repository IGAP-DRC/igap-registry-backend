package com.igap.registry.security.jwt.utils;



import com.igap.registry.entities.core.user.User;
import com.igap.registry.helper.Security;
import com.igap.registry.services.core.user.user.service.LoadUserByUsernameService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
/**
 * class JwtUtils
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 Haute sel
 */
@Component
public class JwtUtils {


    private final LoadUserByUsernameService loadUserByUsernameService;

    public JwtUtils(LoadUserByUsernameService loadUserByUsernameService) {
        this.loadUserByUsernameService = loadUserByUsernameService;
    }




    public Map<String, String>  generateJwtToken(String username, long expirationTime) {

        User account = loadUserByUsernameService.loadUserByUsername(username);

        final Map<String, Object> claims = Map.of(
                "mail", Objects.isNull(account.getEmail()) ? "Email not found":account.getEmail(),
                Claims.ID, account.getId(),
                Claims.EXPIRATION, new Date(expirationTime),
                Claims.SUBJECT, account.getUsername()
        );

        final String bearer = Jwts.builder()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(expirationTime))
                .setSubject(account.getUsername())
                .setClaims(claims)
                .signWith(key(), SignatureAlgorithm.HS512)
                .compact();

        return Map.of(Security.BEAR, bearer);
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode("8ZHVnWD0BrMxt9sb3e1DhqeJwhw1i/TwAgdQ8XCjFSR+VsxEkk4lLK08KPbwPjVPLox+vhh8D7gBbprdB5UsJ4FT3tdccsDJsv3Eow1LoVs8U0P6CCjOS3H2QNZUdIAwZjeEnq9SRiTvpix7znqaKC+t4NqW3JOwi67/5qJWnUsS2N51NKwQvbN50wFHI8dEidUK6p7RdE87Uon6iXlkoVXgltwLWRk/Mn4PnmbyY0F7nXkuKO69JyzQ2TdFtcyz3TwLAies78WyItVUFQyYGSipu1TMjDYWY8mDQL12euSI9DT1UVVpHV7zTQQ4/gntKV9nMbHRsPeVg7iSUx9Xf8EH4SbKj5I8Ld4QIY/Fa12z2angwJMjWj7jNe+NIBRjYIk7yYqShulSh2BBb7r3b0jLmIRMeCvzm+Ss7YL/8+/tVPt9WtAaz1W8mznVRBb0FfYcfVmLrgkM4AbsmNcnJ533ztZkDg9QIEmOSfVafuGF4LSAJIds1q+N/YlkCXiT7IYKhaj5UJkxNQzkUGNB63TkTnZxRxy3vB8W5ZsycFMr1MB49OZzLeVInIfZP8/dpJX5Hhlz/LE5GEiyqGbknyHy2OulcPjZEx0eDiqr6MSICNrP3bqPWkdT/BcAlb9JhlVejaXX0qUYqwuVH+mGCV0RkdlB7pktZQuj7sQulfm3jplOpchy7OFGdRig+xNE"));
    }

    public String getUserNameFromJwtToken(String token) {
        return this.getClaims(token, Claims::getSubject);
    }

    public boolean validateJwtToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean isTokenExpired(String token) {
        Date expirationDate = getExpirationDateFromToken(token);
        return expirationDate.before(new Date());
    }

    private <T> T getClaim(String token, Function<Claims, T> function) {
        Claims claims = getAllClaims(token);
        return function.apply(claims);
    }

    private Date getExpirationDateFromToken(String token) {
        return this.getClaim(token, Claims::getExpiration);
    }

    public  <T> T getClaims (String token, Function<Claims, T> function){
        return function.apply(getAllClaims(token));
    }

    public Claims getAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(this.key()).build().parseClaimsJws(token).getBody();
    }
}
