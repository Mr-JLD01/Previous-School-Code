
function u = heat2(f,u0,gbottom,gtop,gleft,gright,a,nx,ny,nt,Lx,Ly,T)
    hx = Lx/(nx-1);
    hy = Ly/(ny-1);
    ht = T/(nt-1);

    u = zeros(nx, ny, nt);

    for(i = 1 : nx)
        for(j=1 : ny)
            u(i, j, 1) = u0( (i-1)*hx, (j-1)*hy );
        end
    end
    
    for(k = 2 : nt)
        for(i = 1 : nx)
            u(i, 1, k) = gbottom( (i-1)*hx, (k-1)*ht );
            u(i, ny, k) = gtop( (i-1)*hx, (k-1)*ht );
        end
    
        for(j = 1 : ny)
            u(1, j, k) = gleft( (j - 1)*hy, (k-1)*ht );
            u(nx, j, k) = gright( (j - 1)*hy, (k-1)*ht );
        end
    end
    
    for(k = 2 : nt)
        for(i = 2 : nx-1)
            for(j = 2:ny-1)
                u(i,j,k) = ht*a*( (u(i-1, j, k-1) - 2*u(i, j, k-1) + u(i+1, j, k-1)) / (hx^2) + (u(i, j-1, k-1) - 2*u(i, j, k-1) + u(i, j+1, k-1)) / (hy^2) ) + ht * f( (i-1)*hx, (j-1)*hy, (k-2)*ht ) + u(i, j, k-1);
            end
        end

    end
end