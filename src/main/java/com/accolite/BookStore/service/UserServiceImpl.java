package com.accolite.BookStore.service;

import com.accolite.BookStore.exception.BookException;
import com.accolite.BookStore.exception.UserException;
import com.accolite.BookStore.model.User;
import com.accolite.BookStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    //usecase1
    @Override
    public User createUser(User u) {
        String email=u.getEmail();
        double wallet_amount = u.getWallet_amount();
        if(isEmailValid(email) && wallet_amount%500==0){
            return userRepository.save(u);
        } else if (wallet_amount % 500 != 0) {
            throw new BookException("The amount should be in multiple of 500");
        } else{
            throw new BookException("please check the email");
        }
    }
    @Override
    public User updateUser(User u) {
        Optional<User> uobj=this.userRepository.findById(u.getUser_id());

        if(uobj.isPresent() ) {
            User user_update = uobj.get();
            user_update.setUser_name(u.getUser_name());
            user_update.setUser_id(u.getUser_id());
            user_update.setEmail(u.getEmail());
            user_update.setSuspended(u.getSuspended());
            user_update.setPhone_no((int) u.getPhone_no());
            user_update.setWallet_amount(u.getWallet_amount());
            return this.userRepository.save(user_update);

        } else{
            throw new BookException("User with id " +u.getUser_id()+" is not present");
        }

    }

    @Override
    public boolean isEmailValid(String email) {
        String exp="^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;
        Pattern pattern = Pattern.compile(exp,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.matches()){
            return true;
        }
        else return false;
    }

    @Override
    public List<User> getUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(long user_id) {
        Optional<User> userObj = this.userRepository.findById(user_id);
        if(userObj.isPresent()){
            return userObj.get();
        }else{
            throw new UserException("User didn't found with Id:"+user_id);
        }
    }

    @Override
    public void deleteUser(long user_id) {
        Optional<User> userObj = this.userRepository.findById(user_id);
        if(userObj.isPresent()){
            this.userRepository.deleteById(user_id);
        }else{
            throw new UserException("Product didn't found with Id:"+user_id);
        }
    }

    @Override
    public double getwallet(User u) {
        Optional<User> uobj=this.userRepository.findById(u.getUser_id());
        if(uobj.isPresent()){
            return uobj.get().getWallet_amount();
        }
        else{
            throw new BookException("User with id " +u.getUser_id()+" is not present");
        }
    }

    @Override
    public User updateWallet(User u) {
        Optional<User> uobj=this.userRepository.findById(u.getUser_id());
        if(uobj.isPresent() && u.getWallet_amount()%500==0) {
            double current_wallet_value=uobj.get().getWallet_amount();
            User user_update = uobj.get();
            user_update.setWallet_amount(u.getWallet_amount()+current_wallet_value);
            return this.userRepository.save(user_update);

        }else if (u.getWallet_amount()%500!=0) {
            throw new BookException("The wallet value added should be multiple of 500");
        }
        else{
            throw new BookException("User with id " +u.getUser_id()+" is not present");
        }
    }
}
