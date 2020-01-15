package cn.linguo.service.impl;

import cn.linguo.entity.User;
import cn.linguo.mapper.UserMapper;
import cn.linguo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author linguo
 * @since 2020-01-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
