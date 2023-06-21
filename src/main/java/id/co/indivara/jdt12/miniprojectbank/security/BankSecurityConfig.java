package id.co.indivara.jdt12.miniprojectbank.security;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class BankSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("user")
                .and().withUser("admin").password("{noop}password").roles("user","admin");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET,"/bank/**").hasRole("user")
                .antMatchers(HttpMethod.GET,"/bank/**").hasRole("admin")
                .and().csrf().disable().formLogin().disable();
    }
}
