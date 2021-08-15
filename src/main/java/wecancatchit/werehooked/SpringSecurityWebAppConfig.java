package wecancatchit.werehooked;

// import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// @EnableOAuth2Sso  
@Configuration  
public class SpringSecurityWebAppConfig extends WebSecurityConfigurerAdapter {  
  
    @Override  
  protected void configure(HttpSecurity http) throws Exception {  
        http.authorizeRequests()  
            .antMatchers("/**").permitAll()
            .antMatchers("/resources/**").permitAll()
            .antMatchers("/home").permitAll() 
            .antMatchers("/rules").permitAll()
            .antMatchers("/static/**").permitAll()  
            .anyRequest().authenticated();  
    }  
      
}