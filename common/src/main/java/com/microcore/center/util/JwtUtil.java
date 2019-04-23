package com.microcore.center.util;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 *
 */
public class JwtUtil {

	private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCUK/qM1VeakoKSNO6cQY+Eheoo61yb37tHmUnz7tOVXCrF2V5By/8hoHa40DZIowKFpAwDh+FFi9559CmwWvN70MdkvGHv7trybpE0aRcqD6USPl6frZrdzuNHq7nfht8MfC9xo/f+S0Z6R/DfsU46wdrUjQy481Ij8jpnvHJjJQIDAQAB";
	private static String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJQr+ozVV5qSgpI07pxBj4SF6ijrXJvfu0eZSfPu05VcKsXZXkHL/yGgdrjQNkijAoWkDAOH4UWL3nn0KbBa83vQx2S8Ye/u2vJukTRpFyoPpRI+Xp+tmt3O40erud+G3wx8L3Gj9/5LRnpH8N+xTjrB2tSNDLjzUiPyOme8cmMlAgMBAAECgYBd7SL+c5781TMAC53WX5jioSE2nzwtcz38vScsApENdUeH86rUesRYRKf9r785fFv063DSLCiZNXjqReTHbmA5eoi6XGSLDIkyyOnJWSRLJvhtlWFSAvjPwS7gTKoGlIH2hAZvk+vQQH1bYdzN+IK5C+GFPICYEZfce/kohitkYQJBAOUVM4Nkva/q1ApfuJWg5DoN4eyN8Gj+j7f6m1mLyiUyPqXbc40mkMeP0F37BxhvQPfUTNvG2tSyI58n0Wi8P+cCQQCllPpsBLFgYnFlDW79oCYdvVEQ/wcWy8+IDeIhtOQkixDxaTenVhwl0TYFau2EA5gKo2L6cXeqrbe8SYaa+JMTAkEAqTLIknKU29rw9ByRBAsKpopcZNDNUW87jWKO3UuvaVu8A9qbdRSX+J2TA+cF7Zk2fhWTEvzD4jcUslfBhr8L3wJAR7iO++jQd+JMIaw+7ibHO8x757O/e1VOkC0LTPRQea+u6BJeI+I9kPfcwV3+gVcZLUp2Heq2HbzfP/RNFKUk9wJANb9Dh60iaX9sn07M73TShT50W0gphOi9Dfo6+eajprYWaVoZtot9n9UzRxWG6CQeNgwlicHWaBlDUmqjKefL5A==";

	private static JwtParser jwtParser ;

	public static String createJwtToken(String id, Date exp) throws Exception {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.RS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).signWith(signatureAlgorithm,
				RSAUtils.string2PrivateKey(privateKey));
		if (exp != null) {
			builder.setExpiration(exp);
		}
		return builder.compact();
	}

	public static String createJwtToken(String id, Date exp, PrivateKey privateKey) throws Exception {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.RS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setExpiration(exp).signWith(signatureAlgorithm,
				privateKey);
		return builder.compact();
	}

	public static Jws<Claims> parseJwtToken(String token) throws Exception {
		if(jwtParser ==null) {
			jwtParser = Jwts.parser().setSigningKey(RSAUtils.string2PublicKey(publicKey)) ;
		}
		return jwtParser.parseClaimsJws(token);
	}

	public static Jws<Claims> parseJwtToken(String token, PublicKey publicKey) throws Exception {

		Jws<Claims> claimsJws = null;
		try {
			claimsJws = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token);
		} catch (ExpiredJwtException e) {
			System.out.println("token超时");
			return null;
		}
		return claimsJws;
	}

	public static void main(String[] args) throws Exception {
		// Map<String,Object> keyMap = RSAUtils.genKeyPair();
		/*KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(RSAUtils.KEY_ALGORITHM);
		keyPairGen.initialize(1024);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		// PublicKey publicKey = RSAUtils.getPublicKey(keyMap);
		Long t1 = System.currentTimeMillis() ;
		String token = createJwtToken("123456789",null);
		Long t2 = System.currentTimeMillis() ;
		System.out.println("token:" + token);
		Jws<Claims> jws = parseJwtToken(token);
		System.out.println(jws.getBody().get("jti"));
		Long t3 = System.currentTimeMillis() ;
		System.out.println(t2-t1);
		System.out.println(t3-t2);
		
		System.out.println(JwtUtil.createJwtToken("1000000000001", null));*/
		String token = JwtUtil.createJwtToken("1000000000001", null) ;
		System.out.println(JwtUtil.parseJwtToken(token));
		System.out.println(JwtUtil.parseJwtToken(token).getBody());
		System.out.println(JwtUtil.parseJwtToken(token).getBody().get("jti"));
		System.out.println(Encode.SHAEncode("super_admin123456"));;
	}

}
