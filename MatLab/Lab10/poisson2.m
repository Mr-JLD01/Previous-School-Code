function u = poisson2(f,gbottom,gtop,gleft,gright,nx,ny,Lx,Ly,accuracy)
    hx = Lx/(nx-1);
    hy = Ly/(ny-1);
    u = zeros(nx,ny);

    for(i = 1:nx)

        u(i,1) = gbottom( (i-1) * hx, 0 );
        u(i,ny) = gtop( (i-1) * hx, Ly );

    end

    for(j = 1:ny)

        u(1,j) = gleft( 0, (j-1) * hy );
        u(nx,j) = gright( Lx, (j-1) * hy );

    end

    max_diff = 1;

    while(max_diff >= accuracy)

        max_diff = 0;

        for(i = 2:nx-1)

            for(j = 2:ny-1)

                uij_old = u(i,j);
                u(i,j) = (( hy^2 * u(i-1,j) + hy^2 * u(i+1,j) + hx^2 * u(i,j-1) + hx^2 * u(i,j+1) - (hx^2 * hy^2) * f( (i-1)*hx, (j-1)*hy) )) /(2*hx^2 + 2*hy^2);
                diff = abs(u(i,j) - uij_old);

                if(diff > max_diff)

                    max_diff = diff;

                end
            end
        end
    end
end