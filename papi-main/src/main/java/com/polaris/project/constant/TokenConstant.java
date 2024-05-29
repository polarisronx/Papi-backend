package com.polaris.project.constant;

import com.polaris.common.entity.User;
import com.polaris.project.service.impl.TokenServiceImpl;

/**
 * @author polaris
 * @version 1.0
 * ClassName TokenConstant
 * Package com.polaris.project.constant
 * Description
 * @date 2024-04-13 23:26
 */
public interface TokenConstant {
    /**
     * @see TokenServiceImpl#createKeyPair()
     * token 密钥对
     */
    public static final String KEY_ID="53f812e56e404c6b8827de22f7b7db7a";
    public static final String PUBLIC_KEY="{\"kty\":\"RSA\",\"kid\":\"53f812e56e404c6b8827de22f7b7db7a\",\"alg\":\"RS256\",\"n\":\"wgI8DkS2wqP8Mbh2FPs4bZpZZFt0ioD9lK-Z9IyC8AAnAArwepX4Tmi7iLttnLiZfMyY9B-6zHGu6WAr-d8FJEANhxVtOvwZtAmUf2N5oHru6BlZKVhVnYkdSQBH2EC793NcAGEyOIAwWMFOMB_P4HO6bnDlWJGa7JHNRK26CMDGSdgvm2zs9-ONEk638s-8F1k9RjlC6oTI7ptekAq47vdBFTkM9u8E64Z-d4lxiYcoPUV1eHqvCYgZUiqQlzPJQO_UCzEdStE8LebA9MW-RP2PJTy45JqVPBSZFD2ef0tu5VPhybZEqIJUF4Uj1ybgmknHOuNP0afI8esYWT1ekw\",\"e\":\"AQAB\"}";
    public static final String PRIVATE_KEY="{\"kty\":\"RSA\",\"kid\":\"53f812e56e404c6b8827de22f7b7db7a\",\"alg\":\"RS256\",\"n\":\"wgI8DkS2wqP8Mbh2FPs4bZpZZFt0ioD9lK-Z9IyC8AAnAArwepX4Tmi7iLttnLiZfMyY9B-6zHGu6WAr-d8FJEANhxVtOvwZtAmUf2N5oHru6BlZKVhVnYkdSQBH2EC793NcAGEyOIAwWMFOMB_P4HO6bnDlWJGa7JHNRK26CMDGSdgvm2zs9-ONEk638s-8F1k9RjlC6oTI7ptekAq47vdBFTkM9u8E64Z-d4lxiYcoPUV1eHqvCYgZUiqQlzPJQO_UCzEdStE8LebA9MW-RP2PJTy45JqVPBSZFD2ef0tu5VPhybZEqIJUF4Uj1ybgmknHOuNP0afI8esYWT1ekw\",\"e\":\"AQAB\",\"d\":\"oritFmqbv3U7OZi1sbNkCMnE4F-0x9aY2fTO9EZGLHZ0P5ztRmQy99DwOia6MRDD6-DPCTLzwjY3tpZrTBC6h0USE5LtIuP_yvmeC5qrkOaLKzDXj83_QTqXzXrmx4LEJTAkokzjinA6HLdFlSeZe3CVlbwrILY_ctx3hnsP5fYUa6_U_R6kHXx_BMhFtBKtn2-FzOtBj9T6tkm2tQu72Y4SayVAsLs87TBGBKbDVISm0CzbOtgsNUPPmzDCW4MEzquW4bP6J3WInGK3XuFOGFA_-9_ElF8DqSfFXHx31jSNSFSZqmSClY2K3VZuOwtiGMSXak-KHVqx9v2i0vXwwQ\",\"p\":\"47sDxD64KXEgozHmv5Lz_3W6mUuWWMtg7jQc_oZisOz4sVbtSKx9wEPsFwniCxqDV7TsH0vjkxrbigQaQE-OhuCnWjUGdKuhhRYpoTNF_9ru07p1whtQURKW2xbiOYF30Ztb7mekqfgzWBIpknOviAKb4S2h8ZhvPAASSe498z8\",\"q\":\"2heVj9oZioCcZ7Dnyn1T4tklwEZD6eI63jcs-vZh8doVAnSGzYpI0R2TPEw_mWy0egjCpjSyWWH81ANvJY_wOJHCi29bvy8nJUF9Uh8NAMzytnFMa5IrMWIbf-XgPI3YhCd_AHcgyEhuufLyOQr4iHMioJIVyvT6oYDYWcwpw60\",\"dp\":\"ekB1Hy7EUosGiFVLmGBdWDBtQcoQJg7YNEgJoKGn7W7peto9e5wNzd8oqJ2HmYpcJANeFtb4jooGfSsCpK-QxdtoO8bndk6E4Rsqsf0CgP2Y5FTezps3HK6sCWVZgKF-HyoVygAdp5k0hv0JEDPGcW9lGxcSLs40OLOZHdMlsqU\",\"dq\":\"sOamazvGseCmfTkymr3T2FK422BjYAggJfVtZ9eIFOwHVKl-WqSLcgviTOuwPtu8_Ku0b6qY7AWeVb6_XiGGAezBd-aI7efqgb7AT2deXcLgMPpvuWWj4XepxLGKlLOd53w9-PuoPKz8G5qjvX9Xnx58_O_h-3GBBpWDaDtBuTU\",\"qi\":\"tEBANNOPVKEFij0Ywyak7r_xGbwwHpaH9DGD5crofk68dUL_GnA1lmfcTvDEXiyTnPptHVDFPGot6yglqZRaXQaNKGgooupiQTPIEpwq1oeniouYdKdau1X5E3qlGloxF02tCTqUB5-XhkGn3S4BcMYwx75f158nnyX2PPsxUdY\"}\n";

    /**
     * @see TokenServiceImpl#createAccessToken(User)
     *
     * access_token
     */
    public static final String ACCESS_TOKEN_PREFIX = "access_token:";
    public static long ACCESS_TOKEN_EXPIRATION_TIME = 60 * 60 * 24;

    /**
     * @see TokenServiceImpl#createRefreshToken(com.polaris.common.entity.User)
     *
     * refresh_token
     */
    public static final String REFRESH_TOKEN_PREFIX = "refresh_token:";
    public static long REFRESH_TOKEN_EXPIRATION_TIME = 4 * 60 * 60 * 24;

    public static final int MAX_FUTURE_VALIDITY_IN_MINUTES = 5256000;
    public static final int ALLOWED_CLOCK_SKEW_IN_SECONDS = 30;
}
