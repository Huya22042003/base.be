
## Google
spring.security.oauth2.client.registration.google.client-id=361435587290-jd2dlbkk8s65htcd7vacse159jtm6d9o.apps.googleusercontent.com
spring.security.oauth2.client.registration.google.client-secret=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
#spring.security.oauth2.client.registration.google.redirect-uri=http://localhost:3000/login/oauth2/code/google
spring.security.oauth2.client.registration.google.scope=email,profile
spring.security.oauth2.client.provider.google.authorization-uri=https://accounts.google.com/o/oauth2/auth
spring.security.oauth2.client.provider.google.token-uri=https://accounts.google.com/o/oauth2/token
spring.security.oauth2.client.provider.google.user-info-uri=https://www.googleapis.com/oauth2/v3/userinfo
spring.security.oauth2.client.provider.google.user-name-attribute=sub

#Facebook
spring.security.oauth2.client.registration.facebook.client-id=890110845747451
spring.security.oauth2.client.registration.facebook.client-secret=e26fde8c2143c7d07497360472fe0383
spring.security.oauth2.client.registration.facebook.scope=email,public_profile

#Linkedin
spring.security.oauth2.client.registration.linkedin.client-id=7853kt22c2qm2q
spring.security.oauth2.client.registration.linkedin.client-secret=WPL_AP0.jWeE5akL7WGRoHsi.MjczNjgyMDUy
spring.security.oauth2.client.registration.linkedin.scope=r_emailaddress,r_liteprofile
spring.security.oauth2.client.registration.linkedin.client-authentication-method= post
spring.security.oauth2.client.registration.linkedin.redirect-uri=http://localhost:3000
spring.security.oauth2.client.registration.linkedin.authorization-grant-type= authorization_code
spring.security.oauth2.client.provider.linkedin.authorization-uri=https://www.linkedin.com/oauth/v2/authorization
spring.security.oauth2.client.provider.linkedin.token-uri=https://www.linkedin.com/oauth/v2/accessToken
spring.security.oauth2.client.provider.linkedin.user-info-uri=https://api.linkedin.com/v2/me
spring.security.oauth2.client.provider.linkedin.user-name-attribute= id